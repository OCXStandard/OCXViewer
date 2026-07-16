@echo off
setlocal

REM ============================================================================
REM  install-wix.bat - install the WiX Toolset v4 that jpackage needs to build
REM  a Windows MSI/EXE installer.
REM
REM  Installs the `wix` .NET global tool and the two WiX extensions jpackage
REM  passes to `wix build` (WixToolset.UI.wixext + WixToolset.Util.wixext).
REM  Without those extensions in the global cache, jpackage fails with exit 144.
REM
REM  Usage:
REM    install-wix.bat                    online: install from nuget.org
REM    install-wix.bat C:\path\to\nupkgs  offline: install from a folder of
REM                                       WiX *.nupkg files
REM
REM  All NuGet operations use a private, isolated nuget.config (only the source
REM  chosen above), so a broken corporate feed in the machine's NuGet config
REM  (e.g. an Artifactory mirror returning 403) is ignored.
REM
REM  Notes:
REM   * Run as the SAME user that will build the installer - `wix extension add
REM     -g` writes a per-user cache. On a CI node, run as the build agent account.
REM   * WiX 4.0.6 targets .NET 6 - a .NET 6 runtime must be installed.
REM   * jpackage comes from the JDK; it is not installed here.
REM ============================================================================

REM Run the work in a subroutine so every exit (success or error) flows through
REM the pause below - handy when the script is launched by double-click.
call :main %*
set "RC=%errorlevel%"
echo.
pause
exit /b %RC%

:main

set "WIX_VERSION=4.0.6"
set "OFFLINE_DIR=%~1"
set "WIX_EXE=%USERPROFILE%\.dotnet\tools\wix.exe"
set "CFGDIR=%TEMP%\wix-setup-cfg"
set "NUGET_CFG=%CFGDIR%\nuget.config"

echo [wix-setup] Target WiX version: %WIX_VERSION%

REM --- 1. dotnet available? ---------------------------------------------------
where dotnet >nul 2>&1
if errorlevel 1 (
  echo [wix-setup] ERROR: 'dotnet' not found on PATH. Install the .NET SDK first.
  exit /b 1
)

REM --- 2. .NET 6 runtime present? (WiX 4.0.6 targets net6.0) ------------------
dotnet --list-runtimes | findstr /C:"Microsoft.NETCore.App 6." >nul 2>&1
if errorlevel 1 (
  echo [wix-setup] WARNING: no .NET 6 runtime detected. WiX %WIX_VERSION% targets
  echo [wix-setup]          net6.0 and may fail to run if 'wix --version' errors below.
)

REM --- 3. pick the package source and write an ISOLATED nuget.config ----------
if not "%OFFLINE_DIR%"=="" (
  if not exist "%OFFLINE_DIR%" (
    echo [wix-setup] ERROR: offline folder "%OFFLINE_DIR%" does not exist.
    exit /b 1
  )
  set "WIX_SOURCE=%OFFLINE_DIR%"
  echo [wix-setup] Offline mode: source = "%OFFLINE_DIR%"
) else (
  set "WIX_SOURCE=https://api.nuget.org/v3/index.json"
  echo [wix-setup] Online mode: source = nuget.org
)
if not exist "%CFGDIR%" mkdir "%CFGDIR%"
> "%NUGET_CFG%"  echo ^<?xml version="1.0" encoding="utf-8"?^>
>>"%NUGET_CFG%"  echo ^<configuration^>^<packageSources^>^<clear /^>
>>"%NUGET_CFG%"  echo ^<add key="wix-src" value="%WIX_SOURCE%" /^>
>>"%NUGET_CFG%"  echo ^</packageSources^>^</configuration^>

REM --- 4. install (or ensure) the wix global tool, isolated config only -------
dotnet tool list --global | findstr /I /B /C:"wix " >nul 2>&1
if errorlevel 1 (
  echo [wix-setup] Installing wix %WIX_VERSION% ...
  dotnet tool install --global wix --version %WIX_VERSION% --configfile "%NUGET_CFG%"
) else (
  echo [wix-setup] wix already installed; ensuring version %WIX_VERSION% ...
  dotnet tool update  --global wix --version %WIX_VERSION% --configfile "%NUGET_CFG%"
)
if errorlevel 1 (
  echo [wix-setup] ERROR: wix tool install/update failed.
  exit /b 1
)
if not exist "%WIX_EXE%" (
  echo [wix-setup] ERROR: wix.exe not found at "%WIX_EXE%".
  exit /b 1
)

REM --- 5. add the two extensions jpackage requires ---------------------------
REM     Run from CFGDIR so wix's NuGet restore also uses the isolated config.
echo [wix-setup] Adding extensions (UI + Util) ...
pushd "%CFGDIR%"
"%WIX_EXE%" extension add -g WixToolset.UI.wixext/%WIX_VERSION%
"%WIX_EXE%" extension add -g WixToolset.Util.wixext/%WIX_VERSION%
popd

REM --- 6. verify --------------------------------------------------------------
echo.
echo [wix-setup] wix version:
"%WIX_EXE%" --version
echo [wix-setup] global extensions:
"%WIX_EXE%" extension list -g > "%TEMP%\wix-ext-list.txt" 2>&1
type "%TEMP%\wix-ext-list.txt"
findstr /I "WixToolset.UI.wixext" "%TEMP%\wix-ext-list.txt" >nul || (
  echo [wix-setup] ERROR: WixToolset.UI.wixext is not installed.
  del "%TEMP%\wix-ext-list.txt" >nul 2>&1
  exit /b 1
)
findstr /I "WixToolset.Util.wixext" "%TEMP%\wix-ext-list.txt" >nul || (
  echo [wix-setup] ERROR: WixToolset.Util.wixext is not installed.
  del "%TEMP%\wix-ext-list.txt" >nul 2>&1
  exit /b 1
)
del "%TEMP%\wix-ext-list.txt" >nul 2>&1
rd /s /q "%CFGDIR%" >nul 2>&1

echo.
echo [wix-setup] OK - WiX v%WIX_VERSION% is ready.
echo [wix-setup] If 'wix' is not recognized in this shell, open a new terminal so
echo [wix-setup] %USERPROFILE%\.dotnet\tools is on PATH (jpackage searches PATH).
echo [wix-setup] jpackage can now build MSI/EXE installers.
exit /b 0
