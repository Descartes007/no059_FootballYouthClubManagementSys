const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootr4n67/",
            name: "springbootr4n67",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootr4n67/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "足球青训俱乐部管理后台系统"
        } 
    }
}
export default base
