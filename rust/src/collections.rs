/// Collections playground
pub fn run() {

    /* Vectors */

    // create
    // let mut v: Vec<i32> = Vec::new();
    let mut v = vec![1, 2, 3];

    // push
    v.push(4);

    for i in 5..11 {
        v.push(i);
    }

    // print vector
    println!("v = {:?}", v);

    // access
    let first: &i32 = &v[0];
    println!("v[0] = {}", first);
    //or (securest - can check not exists)
    let second: Option<&i32> = v.get(1);
    println!("v[1] = {:?}", second);



}