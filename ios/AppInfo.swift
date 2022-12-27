@objc(AppInfo)
class AppInfo: NSObject {

  @objc
  func constantsToExport() -> [AnyHashable : Any]! {
    let kVersion = "CFBundleShortVersionString"
    let kBuildNumber = "CFBundleVersion"
    
    let dictionary = Bundle.main.infoDictionary!
    
    let version = dictionary[kVersion] as! String
    let buildVersion = dictionary[kBuildNumber] as! String
    
    return ["appVersion": version, "buildVersion": buildVersion]
  }

  @objc(multiply:withB:withResolver:withRejecter:)
  func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    resolve(a*b)
  }
  
}
