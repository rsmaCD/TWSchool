class Person{
    constructor(id,name,age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    introduce(){
        return `My name is ${this.name}. I am ${this.age} years old.`;
    }
}

class Class{
    constructor(classNum){
        this.number = classNum;
    }
    getClassNum(){
        return this.number;
    }

    assignLeader(student){
        this.leader = student;
    }

    getClassLeader(){
        return this.leader;
    }
}

class Student extends Person{
    constructor(id,name,age,classObj){
        super(id,name,age);
        this.class = classObj;
    }

    getClassObj(){
        return this.class;
    }
    introduce(){
        if(this.class.getClassLeader() === this){
            return super.introduce() + ` I am a Student. I am Leader of Class ${this.class.getClassNum()}.`;
        }
        return super.introduce() + ` I am a Student. I am at Class ${this.class.getClassNum()}.`;
    }
}

class Teacher extends Person{
    constructor(id,name,age,classObj){
        super(id,name,age);
        this.class = classObj;
    }
    introduce(){
        if(this.class === undefined){
            return super.introduce() + ` I am a Teacher. I teach No Class.`;
        }
        return super.introduce() + ` I am a Teacher. I teach Class ${this.class.getClassNum()}.`;
    }
}

module.exports = {
    Person,
    Student,
    Class,
    Teacher
}