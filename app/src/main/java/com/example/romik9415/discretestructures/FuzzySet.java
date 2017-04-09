package com.example.romik9415.discretestructures;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FuzzySet {
    HashMap<String,Double> set;

    public FuzzySet(){
        set = new HashMap<>();
    }

    public void addElement(String k,Double v){
        if(!set.containsKey(k))
            set.put(k,v);
    }
    public HashMap<String, Double> set(){
        return set;
    }


    public double calculateEntropy() {

        if(getRealSize() == 0)
            return 1;
        //NORM
        Double sum=new Double(0);
        for (String s : set.keySet()) {
            if(set.get(s) != 0){
                sum += set.get(s) * Math.log(set.get(s));
            }
        }
        return Algorithm.round(-sum/ Math.log(getRealSize()));
    }

    public String toStr(){
        String str = "{";
        for (String s : set.keySet()) {
          str += "("+s+" , "+Algorithm.round(set.get(s))+"), ";

        }
        str+="}";
        return str;
    }

    public FuzzySet closest(){


        FuzzySet closest = new FuzzySet();
        //Element[] arr = set.toArray(new Element[set.size()]);

        for (String s : set.keySet()) {
            if(set.get(s)>.5)
                closest.set().put(s,1d);
            else
                closest.set().put(s,0d);
        }

        System.out.println("closest: "+closest.toStr());
        return closest;
    }

    public double getLinearIndex(){
        return Algorithm.round(2 * hammingDistance(this, closest())/getRealSize());
       }
    public double getQuadIndex(FuzzySet another){
        return  Algorithm.round( 2 * euclidDistance(this, another)/Math.sqrt(getRealSize()));
    }

    public static double hammingDistance(FuzzySet a, FuzzySet b){
        double sum = 0;

        for (String s : a.set().keySet()) {
            Double mb= (b.set.get(s) ==null)?new Double(0):b.set.get(s);
            sum+=Math.abs(a.set.get(s)-mb);
        }
        return sum;
    }

    public static double euclidDistance(FuzzySet a, FuzzySet b) {
        double sum = 0;

        for (String s : a.set().keySet()) {
            Double mb= (b.set.get(s) ==null)?new Double(0):b.set.get(s);
            System.out.println("t: "+Math.pow(a.set.get(s)-mb,2));
            sum+=Math.pow(a.set.get(s)-mb,2);
        }
        sum/=a.set().size();
        return Math.sqrt(sum);
    }

    public int getRealSize(){
        int size  = 0;
        for (String s : set.keySet()) {
            if(set.get(s) !=0)size++;
        }
        return size;
    }


    public static List<FuzzySet> Boolean(List<String> inputSet,List<Double> inputVals){
        List<FuzzySet> B = new ArrayList<>();
        List<int[]> list = new BruteForce(0,inputVals.size()-1,inputSet.size()).getBruteforceList();
        for (int[] vals : list) {
           FuzzySet f = new FuzzySet();
            for (int i=0;i<inputSet.size();i++) {
                f.addElement(inputSet.get(i),inputVals.get(vals[i+1]));
            }
            B.add(f);
        }
        return B;
    }

}
