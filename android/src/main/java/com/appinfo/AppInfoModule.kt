package com.appinfo

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise

class AppInfoModule(reactContext: ReactApplicationContext) :
  ReactContextBaseJavaModule(reactContext) {

  override fun getName(): String {
    return NAME
  }

  override fun getConstants(): Map<String, Any>? {
    val constants: MutableMap<String, Any> = HashMap()
    constants["appVersion"] = reactApplicationContext.packageManager.getPackageInfo(reactApplicationContext.packageName, 0).versionName
    constants["buildVersion"] = reactApplicationContext.packageManager.getPackageInfo(reactApplicationContext.packageName, 0).versionCode
    return constants
}

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  fun multiply(a: Double, b: Double, promise: Promise) {
    promise.resolve(a * b)
  }

  

  companion object {
    const val NAME = "AppInfo"
  }
}
