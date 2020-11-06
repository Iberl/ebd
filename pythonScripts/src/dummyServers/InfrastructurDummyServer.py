#!/usr/bin/env python3

import socket
import time

HOST = '127.0.0.1'  # Standard loopback interface address (localhost)
PORT = 25555       # Port to listen on (non-privileged ports are > 1023)



with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as s:
    s.bind((HOST, PORT))
    s.listen()
    conn, addr = s.accept()
    with conn:
        print('Connected by', addr)
        startTime = time.time()
        while True:
            data = conn.recv(1024)
            if not data:
                break
            dataString = data.decode("utf-8")
            currentTime = time.time()
            print(str(currentTime - startTime) + " " + dataString.rstrip())