package IntroSpect;

public class Config {
    private String name;
    private  String password;
    private  String url;

    public Config() {
    }

    public Config(String name, String password, String url) {
        this.name = name;
        this.password = password;
        this.url = url;
    }

    @Override
    public String toString() {
        return "Config{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
