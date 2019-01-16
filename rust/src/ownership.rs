pub fn basic_ownership_concepts() {

    /*
    * String and other 'Object' types looks like:
    * s1 is pointer (stack) to = String 'hello' (heap)
    * s1 and s2 are pointers to the same object on heap
    */
    let s1 = String::from("hello");
    let s2 = s1;    // s2 takes ownership from s1
                    // s1 from now is unavailable
    // println!("{}, {}", s1, s2); // error because s1 is unavailable

    /* Only you can do is 'deep copy' 'Object' type */
    let s1 = String::from("hello");
    let s2 = s1.clone();
    println!("{}, {}", s1, s2);

    /* 
    * Primitives can be used with 'shallow copy' 
    * pointers and values of x,y are on the stack
    */
    let x = 5;
    let y = x;
    println!("{}, {}", x, y);

    /* 
    * When you pass 'Object' type var into function
    * then after variable is out of scope
    */ 
    let s = String::from("hello"); 
    takes_ownership(s);             // s's value moves into the function...
                                    // ... and so is no longer valid here.


    /* 
    * When you pass primitive type var into function
    * then after variable is still in scope
    */ 
    let x = 5;                     
    makes_copy(x);                  // x would move into the function,
    println!("{}", x);              // still in scope
}

pub fn references_and_borrowing() {

    /*
     * sending reference instead of giving ovnership 
     */
    let s1 = String::from("hello");
    let len = calculate_length(&s1);    // without '&' function takes ownership of s1
                                        // and s1 will be from now unavailable
    println!("Length of {} is {}", s1, len);

    fn calculate_length(s: &String) -> usize {  // s is reference
        s.len()
    }

    // borrowing is having reference as function parameters
    
    /* 
     * mutable references
     * 
     * you can only have ONE mutable reference to variable
     * // let r1 = &mut s
     * // let r2 = &mut s
     *   -> it doens't work
     */
    let mut s = String::from("hello");
    change(&mut s);

    println!("{}", s);

    fn change(some_string: &mut String) {
        some_string.push_str(", world");
    }
}

pub fn slices() {
    let s = String::from("hello");
    let slice = &s[0..2];
    let slice = &s[3..];
    println!("{}", slice);

    let a = [1, 2, 3, 4, 5];
    let slice = &a[1..3];
    println!("{:?}", slice);
}

fn takes_ownership(some_string: String) {
    println!("{}", some_string);
} // Here, some_string goes out of scope

fn makes_copy(some_integer: i32) {
    println!("{}", some_integer);
} // Here, some_integer goes out of scope.

