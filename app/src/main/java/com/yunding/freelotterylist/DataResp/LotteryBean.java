package com.yunding.freelotterylist.DataResp;

import java.util.List;

/**
 * 类 名 称：FreeLotteryList
 * <P/>描    述：
 * <P/>创 建 人：CM
 * <P/>创建时间：2018/3/16
 * <P/>修 改 人：CM
 * <P/>修改时间：2018/3/16
 * <P/>修改备注：
 * <P/>版    本：
 */

public class LotteryBean {


    /**
     * rows : 1
     * code : ssq
     * info : 免费接口随机延迟3-6分钟，实时接口请访问www.opencai.net查询、购买或续费
     * data : [{"expect":"2018029","opencode":"01,02,09,14,22,25+05","opentime":"2018-03-15 21:18:20","opentimestamp":1521119900}]
     */

    private int rows;
    private String code;
    private String info;
    private List<DataBean> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * expect : 2018029
         * opencode : 01,02,09,14,22,25+05
         * opentime : 2018-03-15 21:18:20
         * opentimestamp : 1521119900
         */

        private String expect;
        private String opencode;
        private String opentime;
        private int opentimestamp;

        public String getExpect() {
            return expect;
        }

        public void setExpect(String expect) {
            this.expect = expect;
        }

        public String getOpencode() {
            return opencode;
        }

        public void setOpencode(String opencode) {
            this.opencode = opencode;
        }

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public int getOpentimestamp() {
            return opentimestamp;
        }

        public void setOpentimestamp(int opentimestamp) {
            this.opentimestamp = opentimestamp;
        }
    }
}
