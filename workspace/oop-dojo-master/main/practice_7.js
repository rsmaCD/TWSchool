class Person {
    constructor(name,age){
        this.name = name;
        this.age = age;
    }
    introduce(){
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Student extends Person{

    constructor(name,age,classNum){
        super(name, age);
        this.class = classNum;
    }

    introduce(){
        return super.introduce() + " " + `I am a Student. I am at Class ${this.class}.`;
    }
}

class Teacher extends Person{

    constructor(name,age,classNum){
        super(name,age);
        this.class = classNum;

    }

    introduce(){
        if(this.class != undefined){
            return super.introduce() + " " + `I am a Teacher. I teach Class ${this.class}.`;
        }else{
            return super.introduce() + " " + `I am a Teacher. I teach No Class.`;
        }

    }
}

module.exports =  {
    Person,
    Student,
    Teacher
}