import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-app-info' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

const AppInfo = NativeModules.AppInfo
  ? NativeModules.AppInfo
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function multiply(a: number, b: number): Promise<number> {
  return AppInfo.multiply(a, b);
}

export function appVersion(): string {
  return AppInfo.getConstants().appVersion;
}

export function buildVersion(): string {
  return AppInfo.getConstants().buildVersion;
}
