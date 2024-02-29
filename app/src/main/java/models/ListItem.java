package models;

public class ListItem {
    private int imageResource;
    private String text;
    private String link;

    public ListItem() {
    }

    public ListItem(int imageResource, String text, String link) {
        this.imageResource = imageResource;
        this.text = text;
        this.link = link;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
