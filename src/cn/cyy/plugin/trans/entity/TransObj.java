package cn.cyy.plugin.trans.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransObj {
    /**
     * translation : ["假"]
     * basic : {"us-phonetic":"fɔːls","phonetic":"fɔːls","uk-phonetic":"fɔːls","explains":["adj. 错误的；虚伪的；伪造的","adv. 欺诈地"]}
     * query : false
     * errorCode : 0
     * web : [{"value":["错误","假的","虚伪的"],"key":"False"},{"value":["伪旗行动","用冒充身份吸收对象","假旗行动"],"key":"false flag"},{"value":["误报警","假警报","误报"],"key":"false alarm"}]
     */

    private BasicBean basic;
    private String query;
    private int errorCode;
    private List<String> translation;
    private List<WebBean> web;

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public List<String> getTranslation() {
        return translation;
    }

    public void setTranslation(List<String> translation) {
        this.translation = translation;
    }

    public List<WebBean> getWeb() {
        return web;
    }

    public void setWeb(List<WebBean> web) {
        this.web = web;
    }

    public static class BasicBean {
        /**
         * us-phonetic : fɔːls
         * phonetic : fɔːls
         * uk-phonetic : fɔːls
         * explains : ["adj. 错误的；虚伪的；伪造的","adv. 欺诈地"]
         */

        @SerializedName("us-phonetic")
        private String usphonetic;
        private String phonetic;
        @SerializedName("uk-phonetic")
        private String ukphonetic;
        private List<String> explains;

        public String getUsphonetic() {
            return usphonetic;
        }

        public void setUsphonetic(String usphonetic) {
            this.usphonetic = usphonetic;
        }

        public String getPhonetic() {
            return phonetic;
        }

        public void setPhonetic(String phonetic) {
            this.phonetic = phonetic;
        }

        public String getUkphonetic() {
            return ukphonetic;
        }

        public void setUkphonetic(String ukphonetic) {
            this.ukphonetic = ukphonetic;
        }

        public List<String> getExplains() {
            return explains;
        }

        public void setExplains(List<String> explains) {
            this.explains = explains;
        }
    }

    public static class WebBean {
        /**
         * value : ["错误","假的","虚伪的"]
         * key : False
         */

        private String key;
        private List<String> value;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }
    }
}
