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
        if(student.getClass() !== this){
            return `It is not one of us.`;
        }else{
            this.leader = student;
        }
    }

    getClassLeader(){
        return this.leader;
    }

    appendMember(student){
        student.setClass(this);
    }
}

class Student extends Person{
    constructor(id,name,age,classObj){
        super(id,name,age);
        this.class = classObj;
    }

    setClass(classObj){
        this.class = classObj;
    }

    getClass(){
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
    Class,
    Student,
    Teacher
}