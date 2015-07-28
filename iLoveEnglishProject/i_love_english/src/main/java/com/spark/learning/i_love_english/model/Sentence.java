package com.spark.learning.i_love_english.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** @pdOid 41ed7526-40a3-45bc-a991-6adeefcadd39 */

@Entity
@Table(name = "MESSAGES")
public class Sentence extends EntityObject {
   /** @pdOid fcb86c3a-4e64-4027-b2c5-39d97bfeef5e */
   private java.lang.String content;
   
   /** @pdOid 3faa6184-a2e8-40ff-b9c6-9d0741137eb2 */
   public java.lang.String getContent() {
      return content;
   }
   
   /** @param newContent
    * @pdOid 853ee45c-bd52-42ac-b377-522184801706 */
   public void setContent(java.lang.String newContent) {
      content = newContent;
   }
   
   //test spring support
   public static void main(String[] args){
	   ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	   Sentence sentence = context.getBean(Sentence.class);
	   sentence.setContent("Hello,Spring");
	   System.out.println(sentence.getContent());
	   
   }

}