function f5() {
    console.log("f5 rodou");
}

function f4() {
    console.log("f4 rodou");
}

function f3() {
    console.log("f3 rodou");
    setTimeout(f4, 1000);
    setTimeout(f5, 1000);
}

function f2() {
    console.log("f2 rodou");
    f3()
}

function f1() {
    console.log("f1 rodou");
    f2();
}

f1();

function f6() {
    let value = Math.random() * 10;
    while (value > 1) {
        value = Math.random() * 10;
        console.log(value);
    }
}

setTimeout(f6, 1000)

console.log('Término');

let name = 'Leonardo';
let midle = String('Paiva');
let family = new String('Pinto');

console.log(`${name} ${midle} ${family}`);

console.log(typeof name);
console.log(typeof midle);
console.log(typeof family);