package ms.kreations.researchnranking.model;

public class ModelLeaderBoard {
    private String tileName;
    private String tileImage;
    private String tilePoint;

    public String getTileName() {
        return tileName;
    }

    public void setTileName(String tileName) {
        this.tileName = tileName;
    }

    public String getTileImage() {
        return tileImage;
    }

    public void setTileImage(String tileImage) {
        this.tileImage = tileImage;
    }

    public String getTilePoint() {
        return tilePoint;
    }

    public void setTilePoint(String tilePoint) {
        this.tilePoint = tilePoint;
    }

    public ModelLeaderBoard(String tileName, String tileImage, String tilePoint) {

        this.tileName=tileName;
        this.tileImage=tileImage;
        this.tilePoint=tilePoint;

    }
}
