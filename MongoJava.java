package com.redis.mogo.perftest;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class MongoJava {

    public static void main(String args[]) {

        Mongo mongo = new Mongo("localhost", 27017);
        DB db = mongo.getDB("perftest");

        DBCollection collection = db.getCollection("users");
          int noOfElements = 500000;

      long startime = System.currentTimeMillis();
    for (int i=0;i<noOfElements;i++) {
                BasicDBObject document = new BasicDBObject();
                document.put(String.valueOf(i), "some fastastic value" +i);
                collection.insert(document);
            }
              System.out.println("Total Time to write" + noOfElements +"  is "+ ((System.currentTimeMillis() - startime)/1000));

               startime = System.currentTimeMillis();

               int i=0;
               DBCursor cursor = collection.find();
                      while (cursor.hasNext()) {
                           String str = (String)cursor.next().get(String.valueOf(i));
                           //System.out.println(str);
                           i++;

                    }

              System.out.println("Total Time to read " + noOfElements +"  is "+ ((System.currentTimeMillis() - startime)/1000));

        collection.drop();

    }
}
