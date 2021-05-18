package com.algo.algorithms.calender;

import java.util.Collections;
import java.util.PriorityQueue;

class Person{
	  int birth;
	  int death;
	  public Person(int i,int j){
	    birth=i;
	    death=j;
	  }
	}

class FindYearWithPeopleAlive {
  public static void main(String[] args) {
	  PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
	Person[] people=new Person[8];
	people[0]=new Person(2000,2010);
	people[1]=new Person(1975,1986);
	people[2]=new Person(1965,2040);
	people[3]=new Person(1984,2080);
	people[4]=new Person(1955,2013);
	people[5]=new Person(1875,1947);
	people[6]=new Person(1987,2050);
	people[7]=new Person(1947,2005);
	System.out.println(getYearWithMaxPeople(people));
  }
  public static int getYearWithMaxPeople(Person[] people){
	int firstBirth=people[0].birth,lastBirth=people[0].birth;
	for(int i=0;i<people.length;i++){
	  firstBirth=Math.min(people[i].birth,firstBirth);
	  lastBirth=Math.max(people[i].birth,lastBirth);
	}
	int[] delta=getBirthArray(people,firstBirth,lastBirth);
	return getYearWithMaxPeople(delta,firstBirth);
  }
  public static int getYearWithMaxPeople(int[] delta,int firstBirth){
	int currPeople=0,maxPeople=0,maxYear=0;
	for(int i=0;i<delta.length;i++){
	  currPeople+=delta[i];
	  if(currPeople>maxPeople){
		maxPeople=currPeople;
		maxYear=i+firstBirth;
	  }
	}
	System.out.println("maxPeople: "+maxPeople);
	return maxYear;
  }
  public static int[] getBirthArray(Person[] people,int firstBirth,int lastBirth){
	int[] res=new int[lastBirth-firstBirth+1];
	for(int i=0;i<people.length;i++){
	  res[people[i].birth-firstBirth]++;
	  if(people[i].death<lastBirth)res[people[i].death-firstBirth+1]--;
	}
	return res;
  }
}
