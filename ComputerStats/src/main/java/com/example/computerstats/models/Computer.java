package com.example.computerstats.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;


@Entity
public class Computer {

    @Id
    private Long id;

    private String name;

    private String os;
    private String osVersion;
    private String osRelease;

    @Column (length = 500)
    private String cpu;

    private String cpuBits;

    private Long memory;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOs() {
        return os;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public String getOsRelease() {
        return osRelease;
    }

    public String getCpu() {
        return cpu;
    }

    public String getCpuBits() {
        return cpuBits;
    }

    public Long getMemory() {
        return memory;
    }

    public void setProperty(String prop, String value) {
        switch (prop) {
            case "name": setName(value); break;
            case "processor": setCpu(value); break;
            case "OS": setOs(value); break;
            case "Release": setOsRelease(value); break;
            case "version": setOsVersion(value); break;
            case "Machine": setCpuBits(value); break;
            case "Memory": setMemory(Long.parseLong(value)); break;
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public void setOsRelease(String osRelease) {
        this.osRelease = osRelease;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setCpuBits(String cpuBits) {
        this.cpuBits = cpuBits;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }
}
