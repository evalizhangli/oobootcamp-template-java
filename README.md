# OOBootcamp Template Code Base

![Build](https://github.com/oo-bootcamp/template-java/workflows/Build/badge.svg)

ParkingBoy
GraduateParkingBoy
SmartParkingBoy
ParkingManager


停车场
毕业生停车小弟
聪明的停车小弟

停车经理（管理停车小弟），也可以自己停车


# Story（Calarification Needed）

**作为** 停车经理
**我能** 管理多个停车仔，我可以让停车仔停车，也可以自己停车
**从而** 更高效灵活地管理停车场

## AC1
**GIVEN**没有停车小弟，有空位的停车场，一辆车

**WHEN**停车 

**THEN**停车成功，并拿到停车票

### EXAMPLE1
**GIVEN**我有一个有空位的停车场，一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

### EXAMPLE2
**GIVEN**我有停车场1（2个空位），2（1个空位），一辆车
**WHEN**停车
**THEN**停车成功（停到1停车场），拿到停车票

## AC2
**GIVEN** 管理了停车小弟，停车小弟有多个有空位的停车场，一辆车
**WHEN**停车
**THEN**停车成功，并拿到停车票

### EXAMPLE1
**GIVEN** 我管理了1个毕业生停车小弟，小弟有1（1个空位），2（2个空位）两个停车场， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

### EXAMPLE2
**GIVEN**我管理了1个聪明停车小弟，小弟有1（1个空位），2（2个空位）两个停车场， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

### EXAMPLE3
**GIVEN**我管理了2个毕业生停车小弟，小弟1有一个停车场没有空位，小弟2有一个停车场（1个空位）， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

### EXAMPLE4
**GIVEN**我管理了2个聪明停车小弟，小弟1有一个停车场没有空位，小弟2有一个停车场（1个空位）， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票


### EXAMPLE5
**GIVEN**我管理了1个毕业生和1个聪明的停车小弟，毕业生小弟1有一个停车场有空位，聪明小弟有一个停车场（1个空位）， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

### EXAMPLE5
**GIVEN**我管理了1个毕业生和1个聪明的停车小弟，毕业生小弟和聪明小弟都没有空位，我有一个有空位的停车场， 一辆车

**WHEN**停车

**THEN**停车成功，拿到停车票

## AC3
**GIVEN**我的停车场没空位，我管理的多个停车小弟也没余空位，一辆车

**WHEN**停车

**THEN**停车失败

### EXAMPLE1
**GIVEN**我有一个停车场没有空位，没有小弟，一辆车

**WHEN**停车

**THEN**停车失败，告知原因

### EXAMPLE2
**GIVEN**我有一个停车场没有空位，有一个毕业生小弟有一个车场（没有空位），一个聪明小弟有一个车场（没有空位），一辆车

**WHEN**停车

**THEN**停车失败，告知原因

AC4
GIVEN
正确的车票，停有我的车的停车场
WHEN
取车
THEN
取车成功

EXAMPLE1
GIVEN
一张正确的车票，我的车停在停车经理的停车场里面
WHEN
取车
THEN
取车成功

EXAMPLE1
GIVEN
一张正确的车票，我的车停在停车经理的毕业生停车小弟的停车场里面
WHEN
取车
THEN
取车成功

EXAMPLE1
GIVEN
一张正确的车票，停车经理有一个毕业生小弟，一个聪明小弟，我的车停在聪明停车小弟的停车场里面
WHEN
取车
THEN
取车成功

AC5
GIVEN
一张错误的车票，停车场里面没有我的车
WHEN
取车
THEN
取车失败

EXAMPLE1
GIVEN
一张错误的车票，经理停车场里面没有我的车
WHEN
取车
THEN
取车失败

EXAMPLE1
GIVEN
一张错误的车票，经理和1个小弟的一个停车场里面都没有我的车
WHEN
取车
THEN
取车失败
