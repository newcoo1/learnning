#!/bin/sh

# check kernel
uname -a

# enable bbr
 echo "net.core.default_qdisc=fq" >> /etc/sysctl.conf
 echo "net.ipv4.tcp_congestion_control=bbr" >> /etc/sysctl.conf
 sysctl -p

# check bbr
 sysctl net.ipv4.tcp_available_congestion_control
lsmod | grep bbr
