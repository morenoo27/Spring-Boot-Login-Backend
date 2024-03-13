package com.moreno.login.utils;

import java.util.List;

public class Constants {

  public static final List<String> WHITE_LIST_MAPPER = List.of(
    "/user/login",
    "/actuator",
    "/error"
  );
}
