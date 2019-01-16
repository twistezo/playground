#[macro_use]    //macro must be in root file (main.rs)
extern crate serde_derive; 
extern crate chrono;
extern crate reqwest;
extern crate hello_utils;
extern crate kiss3d_playground;

mod basics;
mod collections;
mod bit_bay_checker;
mod ownership;

use hello_utils::insider;

fn main() {
    // bit_bay_checker::menu();
    // ownership::basic_ownership_concepts();
    // ownership::references_and_borrowing();
    // ownership::slices();
    // hello_utils::hello_util_test();
    kiss3d_playground::go();
}