
package de.cadoculus.ocx3;

import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import de.cadoculus.ocx3.impl.*;

/**
*  The <code>KnotVector</code> element
 * defined in namespace <code>https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd</code>.
* 
 * The knot-vector is a list of size m=+n-1 knots where p is the polynomial basis degree and
 * 				n is the number of control points. The knot vector consists of a non-decreasing sequence of values. Knot
 * 				multiplicities can be included. A knot multiplicity means that a knot value can be repeated up to p+1
 * 				times.
 *  

*/
// KnotVector https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd
// KnotVector_T  
// reference type 

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(name = "KnotVector", namespace = "https://3docx.org/fileadmin//ocx_schema//V300//OCX_Schema.xsd")
public  class KnotVector extends KnotVectorT
{

    // the properties serialised to attributes
    // end the properties serialised to attributes


    // start the properties serialised to elements
    // end the properties serialised to elements




      public KnotVector() {
          try {
         } catch (Exception exp) {
                throw new IllegalStateException("failed to set default values", exp);
         }
      }

}
