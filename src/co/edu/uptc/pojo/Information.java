package co.edu.uptc.pojo;

public class Information {
    private figureInformation figureInformation;
    private panelInformation panelInformation;
    private frameInformation frameInformation;

    public Information(co.edu.uptc.pojo.figureInformation figureInformation, co.edu.uptc.pojo.panelInformation panelInformation, co.edu.uptc.pojo.frameInformation frameInformation) {
        this.figureInformation = figureInformation;
        this.panelInformation = panelInformation;
        this.frameInformation = frameInformation;
    }

    public co.edu.uptc.pojo.figureInformation getFigureInformation() {
        return figureInformation;
    }

    public void setFigureInformation(co.edu.uptc.pojo.figureInformation figureInformation) {
        this.figureInformation = figureInformation;
    }

    public co.edu.uptc.pojo.panelInformation getPanelInformation() {
        return panelInformation;
    }

    public void setPanelInformation(co.edu.uptc.pojo.panelInformation panelInformation) {
        this.panelInformation = panelInformation;
    }

    public co.edu.uptc.pojo.frameInformation getFrameInformation() {
        return frameInformation;
    }

    public void setFrameInformation(co.edu.uptc.pojo.frameInformation frameInformation) {
        this.frameInformation = frameInformation;
    }
}
