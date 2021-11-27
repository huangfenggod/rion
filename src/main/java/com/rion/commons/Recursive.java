package com.rion.commons;

import net.sf.jsqlparser.statement.select.Pivot;
import com.rion.pojo.packageDetail;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;

public class Recursive {
    private List<packageDetail> packageDetailList;
    private List<packageDetail> packageDetailAll;
    private List<Integer> list;

    public Recursive(int id, List<packageDetail> packageDetailList){

        this.list=new ArrayList<>();
        this.list.add(id);
        this.packageDetailAll=packageDetailList;
        this.packageDetailList=new ArrayList<>();
    }
    private List<Integer> get(int id){
        List<Integer> list =new ArrayList<>();

        for (packageDetail packagedetail: packageDetailAll ){
            if (packagedetail.getPid()==id){
                list.add(packagedetail.getId());
            }
            if (packagedetail.getId()==id){
                this.packageDetailList.add(packagedetail);
            }
        }
        return list;
    }

    private List<Integer> getChildrenMethod(List<Integer> integerList){
                    if (integerList==null){
                        return null;
                    }
                    for (int i:integerList){
                        getChildrenMethod(get(i));
                    }
                    return null;
    }

    public List<packageDetail> getChildren(){
        this.getChildrenMethod(this.list);
        return this.packageDetailList;
    }





}
