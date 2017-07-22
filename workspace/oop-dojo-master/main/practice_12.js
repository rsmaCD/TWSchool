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
        this.teacherList = [];
    }
    getClassNum(){
        return this.number;
    }

    assignLeader(student){
        if(student.getClass() !== this){
            return `It is not one of us.`;
        }else{
            this.leader = student;
            const event = ` become Leader of Class ${this.number}.`;
            this.informTeachers(student,event);
        }
    }

    getClassLeader(){
        return this.leader;
    }

    appendMember(student){
        student.setClass(this);
        const event = ` has joined Class ${this.number}.`;
        this.informTeachers(student,event);
    }

    informTeachers(student,event){
        for(let i = 0; i < this.teacherList.length;i++) {
            this.teacherList[i].say(student,event);
        }
    }

    isIn(student){
        if(student.getClass() === this){
            return true;
        }
        return false;
    }

    appendTeacher(teacher){
        this.teacherList[this.teacherList.length] = teacher;
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
    getName(){
        return this.name;
    }
}

class Teacher extends Person{
    constructor(id,name,age,classes){
        super(id,name,age);
        this.appendClasses(classes);
    }

    appendClasses(classes){
        this.classes = classes;
        for(let i = 1; i < classes.length;i++){
            classes[i].appendTeacher(this);
        }
    }

    say(student,event){
        console.log(`I am ${this.name}. I know ${student.getName()}${event}`);
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