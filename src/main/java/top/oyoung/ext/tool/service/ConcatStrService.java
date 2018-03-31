package top.oyoung.ext.tool.service;

public class ConcatStrService {

    private String prefix;
    private String subfix;

    public ConcatStrService(String prefix, String subfix) {
        this.prefix = prefix;
        this.subfix = subfix;
    }

    public String doConcat(String context){
        return new StringBuffer(prefix).append(context).append(subfix).toString();
    }
}
