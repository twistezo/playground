//use std::process::Command;
use std::env;
use std::fs;

#[cfg(windows)]
fn main() {
    let profile = env::var("PROFILE").unwrap();
    let deps_dir = format!("target/{}/deps/freetype.dll", profile);
    fs::copy(".cargo/extern/freetype/x86_64/freetype.dll", deps_dir).unwrap();
}
