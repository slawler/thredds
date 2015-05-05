/* Copyright */
package ucar.nc2.ft2.coverage.grid;

import ucar.nc2.Attribute;
import ucar.nc2.util.Indent;

import java.io.IOException;
import java.util.Formatter;
import java.util.List;

/**
 message GridCoverageDataset {
   required string name = 1;
   repeated Attribute atts = 2;
   repeated CoordSys coordSys = 3;
   repeated CoordTransform coordTransforms = 4;
   repeated CoordAxis coordAxes = 5;
   repeated GridCoverage grids = 6;
 }
 * @author caron
 * @since 5/2/2015
 */
public class GridCoverageDataset implements GridCoverageDatasetIF {

  String name;
  List<GridCoordSys> coordSys;
  List<GridCoordTransform> coordTransforms;
  List<GridCoordAxis> coordAxes;
  List<GridCoverage> grids;
  List<Attribute> globalAttributes;

  public void close() throws IOException {
    // NOOP
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public List<GridCoverage> getGrids() {
    return grids;
  }

  public void setGrids(List<GridCoverage> grids) {
    this.grids = grids;
  }

  @Override
  public List<Attribute> getGlobalAttributes() {
    return globalAttributes;
  }

  public void setGlobalAttributes(List<Attribute> globalAttributes) {
    this.globalAttributes = globalAttributes;
  }

  @Override
  public List<GridCoordSys> getCoordSys() {
    return coordSys;
  }

  public void setCoordSys(List<GridCoordSys> coordSys) {
    this.coordSys = coordSys;
  }

  @Override
  public List<GridCoordTransform> getCoordTransforms() {
    return coordTransforms;
  }

  public void setCoordTransforms(List<GridCoordTransform> coordTransforms) {
    this.coordTransforms = coordTransforms;
  }

  @Override
  public List<GridCoordAxis> getCoordAxes() {
    return coordAxes;
  }

  public void setCoordAxes(List<GridCoordAxis> coordAxes) {
    this.coordAxes = coordAxes;
  }

  @Override
  public String toString() {
    Formatter f = new Formatter();
    toString(f);
    return f.toString();
  }

  public void toString(Formatter f) {
    Indent indent = new Indent(2);
    f.format("%sGridDatasetCoverage %s%n", indent, name);
    f.format("%s Global attributes:%n", indent);
    for (Attribute att : globalAttributes)
      f.format("%s  %s%n", indent, att);
    f.format("%s Coordinate Systems:%n", indent);
    for (GridCoordSys cs : coordSys)
      cs.toString(f, indent);
    f.format("%s Coordinate Transforms:%n", indent);
    for (GridCoordTransform t : coordTransforms)
      t.toString(f, indent);
    f.format("%s Coordinate Axes:%n", indent);
    for (GridCoordAxis a : coordAxes)
      a.toString(f, indent);
    f.format("%n%s Grids:%n", indent);
    for (GridCoverage grid : grids)
      grid.toString(f, indent);
  }

  public GridCoverage findCoverage(String name) {
    for (GridCoverage grid : grids)
      if (grid.getName().equalsIgnoreCase(name)) return grid;
    return null;
  }

  public GridCoordSys findCoordSys(String name) {
    for (GridCoordSys gcs : coordSys)
      if (gcs.getName().equalsIgnoreCase(name)) return gcs;
    return null;
  }

}