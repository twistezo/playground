extern crate serde_json;
extern crate reqwest;
extern crate chrono;

use std::io;
use std::io::prelude::*;
use std::path::Path;
use std::process;
use std::fs;
use std::fs::File;
use std::fs::OpenOptions;
use chrono::prelude::*;

const URL_BIT_BAY_JSON: &'static str = "https://bitbay.net/API/Public/BTCPLN/ticker.json";
const BIT_BAY_JSON_FILENAME: &'static str = "ticker.json";
const LOCAL_DATA_FILENAME: &'static str = "data.txt";

// pub static mut deserialized_json: Daily_value;

#[derive(Serialize, Deserialize, Debug)]
struct Daily_value {
    max: f64,
    min: f64,
    last: f64,
    bid: f64,
    ask: f64,
    vwap: f64,
    average: f64,
    volume: f64,
}

// fn struct_to_string(daily_value: &Daily_value) {
    // println!("max = {}", max);
// }

pub fn menu() {
    // send_http_request();
    println!("\n..::Welcome to bitbay checker::..");
    println!("Choose an option:");
    println!("1. Check courses");
    println!("2. About");
    println!("3. Exit\n");

    loop {
        let mut user_choice = String::new();
        // today_date();
        io::stdin()
            .read_line(&mut user_choice)
                .expect("Failed to read line");
                
        let user_choice = user_choice.trim(); //trim `\n` (enter)

        match user_choice.as_ref() {
            "1" => {
                    println!("Your user_choice: 1");
                    create_file(LOCAL_DATA_FILENAME);
                    let mut content = send_http_request(URL_BIT_BAY_JSON);
                    write_to_file(LOCAL_DATA_FILENAME, &content);
                    break;
                },
            "2" => {
                    println!("Your user_choice: 2");
                    break;
                },
            "3" => {
                    println!("Bye..");
                    process::exit(256);
                },
            _ => println!("Wrong user_choice. Try again."),
        }
    }
}

/// read JSON from local file and convert to String
/// return struct Daily_value 
fn read_json(file_name: &str) -> Daily_value {
    let path = Path::new(file_name);    // path to file
    let mut file = File::open(&path).expect("file not found");  // open file
    let mut content = String::new();   
    // reading file to string
    file.read_to_string(&mut content).expect("something went wrong reading the file");
    // JSON to struct
    let deserialized: Daily_value = serde_json::from_str(&content).unwrap();
    println!("read_json:: = {:?}", deserialized);
    deserialized
}

/// read JSON from http by GET and convert to String
/// return String
fn send_http_request(url: &str) -> String {
    let mut resp = reqwest::get(url).unwrap();
    let mut content = String::new();
    resp.read_to_string(&mut content).expect("something went wrong reading the requested file");
    println!("send_http_request:: = {}", content);
    // JSON to struct
    let deserialized: Daily_value = serde_json::from_str(&content).unwrap();
    content
}

/// create file when not exists
fn create_file(file_name: &str) {
    if !path_exists(file_name) {
        println!("not exists");
        let path = Path::new("data.txt");
        let mut file = File::create(&path).expect("something gonna wrong when creating file");
    }
}

/// check if path/file exists
fn path_exists(path: &str) -> bool {
    fs::metadata(path).is_ok()
}

/// write (append) string data to file
fn write_to_file(file_name: &str, string_to_append: &str) {
    let mut file = OpenOptions::new()
        .write(true)
        .append(true)
        .open(file_name)
        .unwrap();

         if let Err(e) = writeln!(file, "{} - {}", today_date(), string_to_append) {
                            println!("{}", e);
    }
}

/// return current date (String)
fn today_date() -> String {
    let local: DateTime<chrono::Local> = Local::now();
    println!("{}", local.format("%d-%m-%Y %H:%M").to_string());
    local.format("%d-%m-%Y %H:%M").to_string()
}
