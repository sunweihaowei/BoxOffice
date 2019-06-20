package com.itheima.boxoffice.bean;

import java.util.List;

public class main {

    /**
     * showapi_res_error :
     * showapi_res_id : 37df96d2e33e43ddb72c39f1e21fec0f
     * showapi_res_code : 0
     * showapi_res_body : {"realTimeRank":{"movieRank":[{"boxOffice":"521.42","boxPercent":"31.19","name":"黑衣人：全球追缉","rank":"1","showDay":"4","sumBoxOffice":"18412.07"},{"boxOffice":"293.33","boxPercent":"17.55","name":"最好的我们","rank":"2","showDay":"12","sumBoxOffice":"31323.08"},{"boxOffice":"202.99","boxPercent":"12.14","name":"哥斯拉2：怪兽之王","rank":"3","showDay":"18","sumBoxOffice":"85683.41"},{"boxOffice":"115.66","boxPercent":"6.92","name":"绝杀慕尼黑","rank":"4","showDay":"5","sumBoxOffice":"2304.39"},{"boxOffice":"108.03","boxPercent":"6.46","name":"X战警：黑凤凰","rank":"5","showDay":"12","sumBoxOffice":"38564.86"},{"boxOffice":"99.34","boxPercent":"5.94","name":"秦明·生死语者","rank":"6","showDay":"4","sumBoxOffice":"2118.05"},{"boxOffice":"89.92","boxPercent":"5.38","name":"妈阁是座城","rank":"7","showDay":"4","sumBoxOffice":"2800.52"},{"boxOffice":"67.93","boxPercent":"4.06","name":"追龙Ⅱ","rank":"8","showDay":"12","sumBoxOffice":"26902.57"},{"boxOffice":"56.89","boxPercent":"3.40","name":"阿拉丁","rank":"9","showDay":"25","sumBoxOffice":"35766.10"},{"boxOffice":"18.81","boxPercent":"1.13","name":"千与千寻","rank":"10","showDay":"-3","sumBoxOffice":"160.31"},{"boxOffice":"97.50","boxPercent":"1.00","name":"其它","rank":"11","showDay":"0","sumBoxOffice":"0.00"}],"realTimeBoxOffice":"1671.8"},"remark":"查询成功！","ret_code":"0"}
     */

    private String showapi_res_error;
    private String showapi_res_id;
    private int showapi_res_code;
    private ShowapiResBodyBean showapi_res_body;

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public String getShowapi_res_id() {
        return showapi_res_id;
    }

    public void setShowapi_res_id(String showapi_res_id) {
        this.showapi_res_id = showapi_res_id;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public ShowapiResBodyBean getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_body(ShowapiResBodyBean showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }

    public static class ShowapiResBodyBean {
        /**
         * realTimeRank : {"movieRank":[{"boxOffice":"521.42","boxPercent":"31.19","name":"黑衣人：全球追缉","rank":"1","showDay":"4","sumBoxOffice":"18412.07"},{"boxOffice":"293.33","boxPercent":"17.55","name":"最好的我们","rank":"2","showDay":"12","sumBoxOffice":"31323.08"},{"boxOffice":"202.99","boxPercent":"12.14","name":"哥斯拉2：怪兽之王","rank":"3","showDay":"18","sumBoxOffice":"85683.41"},{"boxOffice":"115.66","boxPercent":"6.92","name":"绝杀慕尼黑","rank":"4","showDay":"5","sumBoxOffice":"2304.39"},{"boxOffice":"108.03","boxPercent":"6.46","name":"X战警：黑凤凰","rank":"5","showDay":"12","sumBoxOffice":"38564.86"},{"boxOffice":"99.34","boxPercent":"5.94","name":"秦明·生死语者","rank":"6","showDay":"4","sumBoxOffice":"2118.05"},{"boxOffice":"89.92","boxPercent":"5.38","name":"妈阁是座城","rank":"7","showDay":"4","sumBoxOffice":"2800.52"},{"boxOffice":"67.93","boxPercent":"4.06","name":"追龙Ⅱ","rank":"8","showDay":"12","sumBoxOffice":"26902.57"},{"boxOffice":"56.89","boxPercent":"3.40","name":"阿拉丁","rank":"9","showDay":"25","sumBoxOffice":"35766.10"},{"boxOffice":"18.81","boxPercent":"1.13","name":"千与千寻","rank":"10","showDay":"-3","sumBoxOffice":"160.31"},{"boxOffice":"97.50","boxPercent":"1.00","name":"其它","rank":"11","showDay":"0","sumBoxOffice":"0.00"}],"realTimeBoxOffice":"1671.8"}
         * remark : 查询成功！
         * ret_code : 0
         */

        private RealTimeRankBean realTimeRank;
        private String remark;
        private String ret_code;

        public RealTimeRankBean getRealTimeRank() {
            return realTimeRank;
        }

        public void setRealTimeRank(RealTimeRankBean realTimeRank) {
            this.realTimeRank = realTimeRank;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getRet_code() {
            return ret_code;
        }

        public void setRet_code(String ret_code) {
            this.ret_code = ret_code;
        }

        public static class RealTimeRankBean {
            /**
             * movieRank : [{"boxOffice":"521.42","boxPercent":"31.19","name":"黑衣人：全球追缉","rank":"1","showDay":"4","sumBoxOffice":"18412.07"},{"boxOffice":"293.33","boxPercent":"17.55","name":"最好的我们","rank":"2","showDay":"12","sumBoxOffice":"31323.08"},{"boxOffice":"202.99","boxPercent":"12.14","name":"哥斯拉2：怪兽之王","rank":"3","showDay":"18","sumBoxOffice":"85683.41"},{"boxOffice":"115.66","boxPercent":"6.92","name":"绝杀慕尼黑","rank":"4","showDay":"5","sumBoxOffice":"2304.39"},{"boxOffice":"108.03","boxPercent":"6.46","name":"X战警：黑凤凰","rank":"5","showDay":"12","sumBoxOffice":"38564.86"},{"boxOffice":"99.34","boxPercent":"5.94","name":"秦明·生死语者","rank":"6","showDay":"4","sumBoxOffice":"2118.05"},{"boxOffice":"89.92","boxPercent":"5.38","name":"妈阁是座城","rank":"7","showDay":"4","sumBoxOffice":"2800.52"},{"boxOffice":"67.93","boxPercent":"4.06","name":"追龙Ⅱ","rank":"8","showDay":"12","sumBoxOffice":"26902.57"},{"boxOffice":"56.89","boxPercent":"3.40","name":"阿拉丁","rank":"9","showDay":"25","sumBoxOffice":"35766.10"},{"boxOffice":"18.81","boxPercent":"1.13","name":"千与千寻","rank":"10","showDay":"-3","sumBoxOffice":"160.31"},{"boxOffice":"97.50","boxPercent":"1.00","name":"其它","rank":"11","showDay":"0","sumBoxOffice":"0.00"}]
             * realTimeBoxOffice : 1671.8
             */

            private String realTimeBoxOffice;
            private List <MovieRankBean> movieRank;

            public String getRealTimeBoxOffice() {
                return realTimeBoxOffice;
            }

            public void setRealTimeBoxOffice(String realTimeBoxOffice) {
                this.realTimeBoxOffice = realTimeBoxOffice;
            }

            public List <MovieRankBean> getMovieRank() {
                return movieRank;
            }

            public void setMovieRank(List <MovieRankBean> movieRank) {
                this.movieRank = movieRank;
            }

            public static class MovieRankBean {
                /**
                 * boxOffice : 521.42
                 * boxPercent : 31.19
                 * name : 黑衣人：全球追缉
                 * rank : 1
                 * showDay : 4
                 * sumBoxOffice : 18412.07
                 */

                private String boxOffice;
                private String boxPercent;
                private String name;
                private String rank;
                private String showDay;
                private String sumBoxOffice;

                public String getBoxOffice() {
                    return boxOffice;
                }

                public void setBoxOffice(String boxOffice) {
                    this.boxOffice = boxOffice;
                }

                public String getBoxPercent() {
                    return boxPercent;
                }

                public void setBoxPercent(String boxPercent) {
                    this.boxPercent = boxPercent;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public String getShowDay() {
                    return showDay;
                }

                public void setShowDay(String showDay) {
                    this.showDay = showDay;
                }

                public String getSumBoxOffice() {
                    return sumBoxOffice;
                }

                public void setSumBoxOffice(String sumBoxOffice) {
                    this.sumBoxOffice = sumBoxOffice;
                }
            }
        }
    }
}

