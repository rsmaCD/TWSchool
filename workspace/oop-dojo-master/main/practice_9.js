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

class ClassObj{
    constructor(classNum){
        this.classNum = classNum;
    }
    getClassNum(){
        return this.classNum;
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
        this.classObj = classObj;
    }

    getClassObj(){
        return this.classObj;
    }
    introduce(){
        if(this.classObj.getClassLeader() === this){
            return super.introduce() + ` I am a Student. I am Leader of Class ${this.classObj.getClassNum()}.`;
        }
        return super.introduce() + ` I am a Student. I am at Class ${this.classObj.getClassNum()}.`;
    }
}

module.exports = {
    Person,
    Student,
    ClassObj
}