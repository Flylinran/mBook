package cn.flylinran.model;

/**
 * 图书类别
 */
public class Category extends AbstractParent {
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", uid='" + uid + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }
}
