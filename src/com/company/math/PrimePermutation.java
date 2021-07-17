package com.company.math;

public class PrimePermutation {
    int N = 1000000007;
    long modfunc(int n){
        if(n==1)return 1;
        else return n*modfunc(n-1)%N;
    }

    boolean IsPrime(int num){
        int base=2;
        if(num==1)return false;
        else if(num==2||num==3)return true;
        else {
            while(base<num){
                if(num%base==0)
                    return false;
                base++;
            }
        }
        return true;
    }


    int numPrimeArrangements(int n){
        int cnt = 0;
        long ret = 1;
        if(n==1)return 1;
        for(int i=1;i<=n;i++){
            if(IsPrime(i) == true)cnt++;
        }

        ret=modfunc(cnt)*modfunc(n-cnt)%N;
        //return cnt;
        return (int)ret;
    }

    public static void main(String[] args){
        System.out.println(new PrimePermutation().numPrimeArrangements(100));
    }
}
