
scalaVersion := "2.11.8"

enablePlugins(AndroidApp)
android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

platformTarget := "android-24"
name := "MyApplication"

instrumentTestRunner :=
  "android.support.test.runner.AndroidJUnitRunner"

scalacOptions ++= Seq("-feature", "-deprecation")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-feature", "-deprecation", "-target:jvm-1.7")


transitiveAndroidLibs in Android := true

run := run in Android

proguardScala in Android := true

useProguard in Android := true

useProguardInDebug in Android := true


javacOptions in Compile ++= "-source" :: "1.7" :: "-target" :: "1.7" :: Nil

libraryDependencies ++=
  "com.android.support" % "appcompat-v7" % "24.0.0" ::
  "com.android.support.test" % "runner" % "0.5" % "androidTest" ::
  "com.android.support.test.espresso" % "espresso-core" % "2.2.2" % "androidTest" :: Nil


/*
import android.PromptPasswordsSigningConfig
import com.sun.scenario.Settings


android.Plugin.androidBuild



enablePlugins(AndroidApp)
android.useSupportVectors

versionCode := Some(1)
version := "0.1-SNAPSHOT"

platformTarget := "android-25"
name := "MyApplication"

scalaVersion := "2.11.8"

scalacOptions ++= Seq("-feature", "-deprecation")

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions ++= Seq("-feature", "-deprecation", "-target:jvm-1.7")

libraryDependencies ++=
  "com.android.support" % "appcompat-v7" % "24.0.0" ::
    "com.android.support.test" % "runner" % "0.5" % "androidTest" ::
    "com.android.support.test.espresso" % "espresso-core" % "2.2.2" % "androidTest" ::
    Nil


transitiveAndroidLibs in Android := true

run := run in Android

proguardScala in Android := true

useProguard in Android := true

useProguardInDebug in Android := true



//proguardOptions in Android ++= Settings.proguardCommons ++ Settings.proguardAkka

packagingOptions in Android := PackagingOptions(
  Seq("META-INF/LICENSE",
    "META-INF/LICENSE.txt",
    "META-INF/NOTICE",
    "META-INF/NOTICE.txt"))

*/
