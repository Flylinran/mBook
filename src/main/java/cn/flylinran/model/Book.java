package cn.flylinran.model;

public class Book extends AbstractParent {

    private String category;

    private String name;

    private String author;

    private Integer price;

    private Integer stock;

    private String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", id=" + id +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", uid='" + uid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}