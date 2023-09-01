  rm(list=ls())
  Data=read.table("datacsv", header = TRUE, sep = ",")
  nrow(Data)
  
  library(DMwR2)
  library(smotefamily)
  #Data=na.omit(Data)
  table(Data$TenYearCHD)
  Data=knnImputation(Data,meth ="Median")
  
  #use SMOTE to create new dataset that is more balanced
  new_df <- SMOTE(X = Data,
                  target = Data$TenYearCHD,
                  K = 6,
                  dup_size = 4)
  new_df=data.frame(new_df$data)
  
  #DataAvg=knnImputation(Data,meth = "weighAvg")
  new_df$age = (new_df$age - mean(new_df$age)) / sd(new_df$age)
  new_df$cigsPerDay = (new_df$cigsPerDay - mean(new_df$cigsPerDay)) / sd(new_df$cigsPerDay)
  new_df$totChol = (new_df$totChol - mean(new_df$totChol)) / sd(new_df$totChol)
  new_df$sysBP = (new_df$sysBP - mean(new_df$sysBP)) / sd(new_df$sysBP)
  new_df$diaBP = (new_df$diaBP - mean(new_df$diaBP)) / sd(new_df$diaBP)
  new_df$BMI = (new_df$BMI - mean(new_df$BMI)) / sd(new_df$BMI)
  new_df$heartRate = (new_df$heartRate - mean(new_df$heartRate)) / sd(new_df$heartRate)
  new_df$glucose = (new_df$glucose - mean(new_df$glucose)) / sd(new_df$glucose)
  
  
  nrow(new_df)
  table(new_df$TenYearCHD)
  
  # Splitting dataset
  split <- sample.split(new_df, SplitRatio = 0.8)
  split
  
  train_reg <- subset(new_df, split == "TRUE")
  test_reg <- subset(new_df, split == "FALSE")
  
  
  
  
  # Training model
  logistic_model <- glm(TenYearCHD~male+age+cigsPerDay+totChol+sysBP+glucose,
                        data = train_reg,
                        family = "binomial")
  
  
  logistic_model
  library(MASS)
  step <- stepAIC(logistic_model, direction = "both", trace = FALSE)
  step
  # Summary
  summary(logistic_model)
  origTest=test_reg$TenYearCHD
  test_reg=subset(test_reg,select=-c(education,currentSmoker,BPMeds,prevalentStroke,
                                     prevalentHyp,diabetes,diaBP,BMI,heartRate))
  
  predictDif=predict(logistic_model,data.frame(male=test_reg$male,age=test_reg$age,cigsPerDay=test_reg$cigsPerDay,
                                               totChol=test_reg$totChol,sysBP=test_reg$sysBP,glucose=test_reg$glucose),type="response")
  
  library(InformationValue)
  
  
  
  #find optimal cutoff probability to use to maximize accuracy
  optimal <- optimalCutoff(test_reg, predictDif)[1]
  optimal
  
  predictDif <- ifelse(predictDif>optimal, 1, 0)
  
  #predictDif=data.frame(predictDif)
  
  
  predictDif=predictDif
  table(origTest, predictDif)
  
  
  missing_classerr <- mean(predictDif != origTest)
  print(paste('Accuracy =', 1 - missing_classerr))
  
  
  library(pROC)
  roc_score=roc(origTest, predictDif) #AUC score
  plot(roc_score ,main ="ROC curve -- Logistic Regression ")
  
  roc_score
  table(origTest, predictDif)
  table(new_df$TenYearCHD)
  print(paste('Accuracy =', 1 - missing_classerr))
  
  