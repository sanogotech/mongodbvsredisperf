package com.redis.mogo.perftest;

import redis.clients.jedis.Jedis;

public class RedisJava {

    public static void main(String args[]) {

          Jedis jedis = new Jedis("localhost");
          System.out.println("Connection to server sucessfully");
          System.out.println("Server is running: "+jedis.ping());
          int noOfElements = 500000;
          long startime = System.currentTimeMillis();
          for (int i=0;i<noOfElements;i++) {
                jedis.set(String.valueOf(i), "some fastastic value" +i);
              }
          System.out.println("Total Time to write" + noOfElements +"  is "+ ((System.currentTimeMillis() - startime)/1000));

           startime = System.currentTimeMillis();

          for (int i=0;i<noOfElements;i++) {
              jedis.get(String.valueOf(i));
            //  System.out.println(jedis.get(String.valueOf(i)));
          }

          jedis.close();
          System.out.println("Total Time to read " + noOfElements +"  is "+ ((System.currentTimeMillis() - startime)/1000));



    }


}
