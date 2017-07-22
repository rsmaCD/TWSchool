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

    isIn(student){
        if(student.getClass() === this){
            return true;
        }
        return false;
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
    constructor(id,name,age,classes){
        super(id,name,age);
        this.classes = classes;
    }
    introduce(){
        if(this.classes === undefined || this.classes.length === 0){
            return super.introduce() + ` I am a Teacher. I teach No Class.`;
        }
        let classesNum = '';
        for(let i = 0;i < this.classes.length;i++){
            classesNum += this.classes[i].getClassNum() + ', ';
        }
        classesNum = classesNum.substring(0,classesNum.length-2);
        return super.introduce() + ` I am a Teacher. I teach Class ${classesNum}.`;
    }

    isTeaching(student){
        for(let i = 0;i < this.classes.length;i++){
            if(this.classes[i].isIn(student)){
                return true;
            }
        }
        return false;
    }
}

module.exports = {
    Person,
    Class,
    Student,
    Teacher
}