/**
 * Created by Kuba on 2017-03-24.
 */
public class word {
    private String id;
    private String engWord;
    private String polWord;
    private String category;
    private String stats;

    public String getId() {
        return id;
    }

    public String getEngWord() {
        return engWord;
    }

    public String getPolWord() {
        return polWord;
    }

    public String getCategory() {
        return category;
    }

    public String getStats() {
        return stats;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEngWord(String engWord) {
        this.engWord = engWord;
    }

    public void setPolWord(String polWord) {
        this.polWord = polWord;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public void add1(){
        setStats(getStats() + "1");
    }

    public void add0(){
        setStats(getStats() + "0");
    }

    public word(String id, String engWord, String polWord, String category, String stats) {
        this.id = id;
        this.engWord = engWord;
        this.polWord = polWord;
        this.category = category;
        this.stats = stats;
    }
    public word(){};

    @Override
    public String toString() {
        return "word{" +
                "id='" + id + '\'' +
                ", engWord='" + engWord + '\'' +
                ", polWord='" + polWord + '\'' +
                ", category='" + category + '\'' +
                ", stats='" + stats + '\'' +
                '}';
    }
}
