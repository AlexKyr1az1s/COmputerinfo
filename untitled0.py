# -*- coding: utf-8 -*-
"""
Created on Wed Dec 29 22:56:12 2021

@author: alexa
"""
#imports
import psutil
import platform
import requests 

#Identification
#sid=AlexDesk
#password=1111

#system information
my_system = platform.uname()
 
print(f"id: 1")
print(f"name: AlexDesk")
print(f"System: {my_system.system}")
print(f"Node Name: {my_system.node}")
print(f"Release: {my_system.release}")
print(f"Version: {my_system.version}")
print(f"Machine: {my_system.machine}")
print(f"Processor: {my_system.processor}")

print(f"Memory :{psutil.virtual_memory().total}")


url = "http://localhost:8080/add/data"
data = {"id": 1, "name": "Alex" ,"processor": my_system.processor,"OS": my_system.system,"Release": my_system.release, "version": my_system.version,"Machine": my_system.machine, "Memory":psutil.virtual_memory().total }

response = requests.post(url, data = data)

print(response.text)
