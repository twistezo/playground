/// Rust basics playground 

pub fn run() {

    /* Variables are immutable by default. (Niezmienne). */
    let x = 5;
    let mut y = 6;


    /* Constants are always immutable */
    const MAX_POINTS: u32 = 100_000;


    /* Shadowing vs mut */
    let q = 5;
    // q = 6;  // error
    let q = 6;  // we declare new value with the same name (shadowing)
    // in shadowing we can mix variables types
    // in mut we can't mix types


    //Convert String to numeric
    let string = "2";
    let converted_string: u32 = string.parse().expect("Not a number");


    /* Scalars */
    // Integers
        //8, 16, 32, 64bit -> unsigned (u8, u16...), signed (i8, i16...)
        // unsigned - only from 0 to + (positive), ex. 8bit -> (2^8) -1 = 255
        // signed - from - to +, ex. 8bit -> 2^(8-1) = 128
        // by DEFAULT rust use i32
        let qq = 12;
        let qq: i32 = 12;
    // Float
        // f32, f64 (default)
        let e = 2.0;
        let e: f64 = 2.0;
    // Boolean
        let r = true;
        let t: bool = false;
    // Char
        let y = 'y';


    /* Compounds */
    // Tuples - way of grouping values with various types
        let tup: (i32, f64, u8) = (500, 6.4, 1);
        let (u, i, o) = tup;
        println!("Tuples: value of i = {}", i);
        //or
        let first_from_tuple = tup.0;
        println!("Tuples: first_from_tuple = {}", first_from_tuple); 
    // Arrays - fixed sized
        let array = [0, 1, 2, 3, 4];
        let first_from_array = array[0];
    

    /* Functions */
    //Statements and expressions - diffrent than other languages
        //statement returns value (calculated in block)
        let p = 5;
        let a = {
            let p = 3;
            p +1
        };
        println!("Statements and expressions: value of a = {}", a);
    //Function with return values
        //arguments in functions always must have type
        fn plus_one(x: i32) -> i32 {
            x+1 // return x+1
        }


    /* Control flow */
    let number = 3;
    //if example
        if number < 5 {
            println!("true");
        } else if number < 4 {
            println!("false");
        } else {
            println!("do something");
        }
    //if with let example
        let condition = true;
        let number = if condition {
            println!("do something");
        };
    //loop
        // loop {
        //     println!("without end");
        // }
    //while
        // while s != 0 {
        //     println!("something");
        // }
        //
        let d = [10, 20, 30, 40, 50];
        let mut index = 0;
        while index < 5 {
            println!("value is: {}", d[index]);
            index = index + 1;
        }
    //for
        for element in d.iter() {
            println!("value is = {}", element);
        }
        //
        for elem in (1..4).rev() {
            println!("{}", elem);
        }
    

    /* Structs */
    // struct-ure is like object with attributes in OOP
    struct User {
        username: String,
        email: String,
        sign_in_count: u64,
        active: bool
    }
    //
    let user1 = User {
        email: String::from("someone@example.com"),
        username: String::from("someusername"),
        active: true,
        sign_in_count: 1
    };
    println!("user1.email: {}", user1.email);
    // Structs example
    #[derive(Debug)]    //for showing rect1 with params in console
    struct Rectangle {
        length: u32,
        width: u32,
    }
    let rect1 = Rectangle { length: 50, width: 30 };
    println!("Area of rectangle is {}", area(&rect1));
    fn area(rectangle: &Rectangle) -> u32 {
        rectangle.length * rectangle.width
    }
    println!("rect1 is {:#?}", rect1);  //:#? -> for good looking debug

    
    /* Methods */
    #[derive(Debug)]
    struct Rectangle2 {
        length2: u32,
        width2: u32,
    }
    impl Rectangle2 {
        fn area2(&self) -> u32 {
            self.length2 * self.width2
        }
    }
    let rect2 = Rectangle2 {length2: 50, width2: 30};
    println!("area is {}", rect2.area2());


    /* Associated functions */
    //like constructors
    struct Rectangle3 {
        length3: u32,
        width3: u32,
    }
    impl Rectangle3 {
        fn square(size: u32) -> Rectangle3 {
            Rectangle3 { length3: size, width3: size }
        }
    }
    let sq = Rectangle3::square(3);


    /* Enum */
    enum IpAddrKind {
        V4, //or with types -> V4(String) or -> V4(u8, u8, u8, u8)
        V6,
    }
    let four = IpAddrKind::V4;
    let six = IpAddrKind::V6;
    fn route(ip_type: IpAddrKind) { }
    // first example
        struct IpAddr {
            kind: IpAddrKind,
            address: String,
        }
        let home = IpAddr {
            kind: IpAddrKind::V4,
            address: String::from("127.0.0.1"),
        };
        //or with types in enum -> let home = IpAddr::V4(String::from("..."));


    /* Option enum */
    enum Option<String> {
        Some(String),
        None,
    } 
    let some_number = Some(5);  // Some haven't type
    let some_string = Some("a string");
    // let absent_number: Option<i32> = None; // None have type !

    
    /* MATCH */
    // match is like 'switch'
    enum Coin {
        Penny,
        Nickel,
        Dime,
        Quarter,
    }
    fn value_in_cents(coin: Coin) -> i32 {
        match coin {
            Coin::Penny => 1,
            Coin::Nickel => 5,
            Coin::Dime => 10,
            Coin::Quarter => 25,
        }
    }
    println!("value_in_cents: {}", value_in_cents(Coin::Dime));
    


    /* if let */
    // SPRÓBOWAĆ PÓŹNIEJ





}






