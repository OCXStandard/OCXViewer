/*
Copyright 2026 Carsten Zerbst

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
package de.cadoculus.ocxviewer.models;

/**
 * An enumeration used to identify the type of objects. This is coarser than the OCX types, e.g. a STIFFENER represents both  Stiffener and EdgeReinforcements
 */
public enum ObjectType {
    SURFACE,
    PANEL,
    PLATE,
    SEAM,
    STIFFENER,
    HOLE
}
