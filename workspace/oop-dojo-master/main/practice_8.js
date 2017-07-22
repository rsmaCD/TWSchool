class Person {
    constructor(name,age){
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
}

class Student extends Person{

    constructor(name,age,classNum){
        super(name, age);
        this.classobj = classNum;
    }

    introduce(){
        return super.introduce() + " " + `I am a Student. I am at Class ${this.getClassNum()}.`;
    }

    getClassNum(){
        return this.classobj.getClassNum();
    }

    getName(){
        return this.name;
    }
}

class Teacher extends Person{

    constructor(name,age,classNum){
        super(name,age);
        this.classobj = classNum;

    }
    getClassNum(){
        return this.classobj.getClassNum();
    }

    introduce(){
        if(this.classobj !== undefined){
            return super.introduce() + " " + `I am a Teacher. I teach Class ${this.getClassNum()}.`;
        }else{
            return super.introduce() + " " + `I am a Teacher. I teach No Class.`;
        }

    }

    introduceWith(student){
        if(this.classobj !== undefined && this.getClassNum() === student.getClassNum()){
            return super.introduce() + ` I am a Teacher. I teach ${student.getName()}.`;
        }else{
            return super.introduce() + ` I am a Teacher. I don't teach ${student.getName()}.`;
        }

    }
}

module.exports =  {
    Person,
    Student,
    Teacher,
    ClassObj
}
