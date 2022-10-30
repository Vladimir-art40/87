package com.vladimir.lessons;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

@Service
@EnableScheduling
@EnableAsync
public class DoingsService {
    public static ArrayList<String> doings = new ArrayList<>();
    private volatile Scanner scanner;

    @Bean
    @Async
    @SneakyThrows
    public void init(){
        for (int i = 0; i < 10; i++) {
            doings.add("Доклад наряда полиции: Нарушение устранено.");
        }
        ServerSocket serverSocket = new ServerSocket(999);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("connected");
            scanner = new Scanner(socket.getInputStream());
        }
    }
/*
    @Scheduled(fixedDelay = 100)
    public void read(){
        try {
            if(scanner.hasNext()){
                if(scanner.nextLine().equals("123")){
                    doings.clear();
                    for (int i = 0; i < 10; i++) {
                        doings.add(scanner.nextLine());
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Нет сигнала");
        }
    }*/
}
