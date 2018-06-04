package com.po.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by ZJ on 08/03/2018.
 */
public class PhotoBytesThreadUtil {

  private String[] strings;

  public PhotoBytesThreadUtil(String[] strings) {
    this.strings = strings;
  }

  public HashMap<String, byte[]> getPhotoBytes() {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(16, 16, 200, TimeUnit.MILLISECONDS,
        new ArrayBlockingQueue<Runnable>(110));
    ArrayList<Future<PhotoBytesRes>> arrayList = new ArrayList<>();
    int i = 0;
    while (i < strings.length) {
      if (executor.getQueue().size() < 100) {
        PhotoBytesCallable photoBytesCallable = new PhotoBytesCallable(strings[i]);
        FutureTask<PhotoBytesRes> task = new FutureTask(photoBytesCallable);
        arrayList.add(task);
        executor.execute(task);
        i++;
      } else {
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    executor.shutdown();

    HashMap<String, byte[]> stringHashMap = new HashMap<>();

    for (Future<PhotoBytesRes> future :
        arrayList) {
      try {
        stringHashMap.put(future.get().getUrl(), future.get().getBytes());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    }

    return stringHashMap;
  }

}
