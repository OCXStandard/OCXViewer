/*
Copyright 2025 Carsten Zerbst

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

import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

/**
 * This enum defines the different view directions for the 3D viewer.
 *
 * @author Carsten Zerbst
 */
public enum ViewDirections {

    STARBOARD("Starboard", new Vector3d(0,1,0), new Point3d(0.5,-1,0.5)),
    PORT("Port", new Vector3d(0,-1,0), new Point3d(0.5,1,0.5)),
    FORWARD("Stern", new Vector3d(-1,0,0), new Point3d(-1,0.5,0.5)),
    AFT("Aft", new Vector3d(1,0,0), new Point3d(1,0.5,0.5)),
    UP("Top", new Vector3d(0,0,-1), new Point3d(0.5,0.5,1)),
    DOWN("Bottom", new Vector3d(0,0,1), new Point3d(0.5,0.5,-1)),
    ISOMETRIC_SB_FWD("Isometric Starboard Forward", new Vector3d(1,1,-1), new Point3d(-1,-1,1)),
    ISOMETRIC_PS_FWD("Isometric Port Forward", new Vector3d(1,-1,-1), new Point3d(-1,1,1)),
    ISOMETRIC_SB_AFT("Isometric SB Aft", new Vector3d(-1,1,-1), new Point3d(1,-1,1)),
    ISOMETRIC_PS_AFT("Isometric Port Aft", new Vector3d(-1,-1,-1), new Point3d(1,-1,1)),;

    private final String name;
    private final Vector3d direction;
    private final Point3d cameraPos;

    private ViewDirections(String name, Vector3d direction, Point3d cameraPos) {
         this.name = name;
         this.cameraPos = cameraPos;
         this.direction = direction;
    }

    public String getName() {
        return name;
    }

    public Vector3d getDirection() {
        return direction;
    }

    public Point3d getCameraPos() {
        return cameraPos;
    }
}
