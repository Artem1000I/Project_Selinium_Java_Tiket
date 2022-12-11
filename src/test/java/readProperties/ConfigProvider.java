import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ?ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                :ConfigFactory.load("application.conf");
    }
    String URL =readConfig().getString("url");
    Integer AGE = readConfig().getInt("age");
    String ADMIN_LOGIN=readConfig().getString("userParams.admin.login");
    String ADMIN_PASSWORD = readConfig().getString("userParams.admin.password");
    Boolean IS_ADMIN_ADMIN = readConfig().getBoolean("userParams.admin.isAdmin");

    String DEMO_PASSWORD = readConfig().getString("usersParams.demo.password");
    String DEMO_LOGIN = readConfig().getString("userParams.demo.login");
    Boolean IS_DEMO_ADMIN = readConfig().getBoolean("userParams.demo.isAdmin");
}
