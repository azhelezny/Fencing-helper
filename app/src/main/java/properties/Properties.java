package properties;

import enums.Levels;

/**
 * Created by andrey on 3/26/15.
 */
public class Properties {
    private Levels level;
    private boolean useRandom;

    private static Properties properties = null;

    private Properties() {
    }

    public static Properties get() {
        if (properties == null) {
            properties = new Properties();
            properties.setUseRandom(true);
            properties.setLevel(Levels.simple);
        }
        return properties;
    }

    public Levels getLevel() {
        return this.level;
    }

    public boolean isUseRandom() {
        return this.useRandom;
    }

    public void setLevel(Levels level){
        properties.level = level;
    }

    public void setUseRandom(boolean shouldUse){
        properties.useRandom = shouldUse;
    }
}
