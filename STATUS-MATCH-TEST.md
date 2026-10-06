# ChromePie 0.7.5 status-match test 1

Based on JayT5/ChromePie. Enable the existing **Apply theme color** setting to activate status/toolbar matching. Disabled retains original default colours.

Resolution runs at each pie opening: opaque Window status colour, named status-area/toolbar backgrounds, browser theme, primary colour, dark grey. Transparent/translucent backgrounds and hidden views are skipped. Gradient fills, composited surfaces and custom-drawn browser surfaces may require a browser-specific follow-up; theme fallback does not guarantee a visual status-area match.

Original selection/submenu shading and icon styling are retained. No automatic icon contrast change in this first test.

Build: upload the project including .github/workflows/build.yml to a GitHub repository, open Actions > Build ChromePie > Run workflow, then download the ChromePie-statusmatch-test1 artifact. The workflow uses Gradle 8.9 and JDK 17. The old incomplete wrapper was removed; locally use `gradle assembleDebug` with Gradle 8.9 and Android SDK 35 installed.

Install the APK, enable it in LSPosed for the browser, enable Apply theme color, and restart the browser. This version uses the separate package ID dev.chet.chromepiestatusmatch and app name ChromePie Status Match. It can coexist with the original ChromePie and has independent settings. Enable only one module for a given browser in LSPosed to avoid duplicate hooks and pie menus. Restart the browser after switching modules. Android may reject installation of target-23 apps: on your computer use `adb install --bypass-low-target-sdk-block path/to/apk` if that specific error occurs.

Test normal/light tabs, dark mode, Incognito and switching tabs. If colour differs, send a screenshot with the pie open and the LSPosed log entries containing `ChromePie:ChromeHelper: status-match`. Logs record source and colour when either changes.

Validation: git diff --check passed. This environment has no Android SDK or Gradle installation; no APK compilation or on-device test was possible. The GitHub Actions build configuration is included but has not been executed. This patch does not update ChromePie's unrelated Chromium hooks or guarantee compatibility with every current browser.
